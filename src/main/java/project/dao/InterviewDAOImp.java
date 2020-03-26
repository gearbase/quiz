package project.dao;

import org.springframework.util.ResourceUtils;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.dozer.CsvDozerBeanReader;
import org.supercsv.io.dozer.ICsvDozerBeanReader;
import org.supercsv.prefs.CsvPreference;
import project.domain.Interview;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InterviewDAOImp implements InterviewDAO {
    private String CSV_FILENAME = "source.csv";

    @Override
    public List<Interview> getInterviewList() throws IOException {
        List<Interview> list = new ArrayList<>();
        File file = ResourceUtils.getFile("classpath:" + CSV_FILENAME);
        final String[] FIELD_MAPPING = new String[] {
                "number",                   // simple field mapping (like CsvBeanReader)
                "question",          // as above
                "answers[0]", // indexed (first element) + deep mapping
                "answers[1]",
                "answers[2]", // indexed (second element) + deep mapping
                "correctAnswer"
        };
        //number,question,answer1,answer2,answer3,rightAnswer
        final CellProcessor[] processors = new CellProcessor[] {
                new Optional(new ParseInt()), // age
                new Optional(),              // consent
                new Optional(),               // questionNo 1
                new Optional(),               // answer 1
                new Optional(),               // questionNo 2
                new ParseInt(),               // questionNo 3
        };

        ICsvDozerBeanReader beanReader = null;
        try {
            beanReader = new CsvDozerBeanReader(new FileReader(file), CsvPreference.STANDARD_PREFERENCE);
            beanReader.getHeader(true); // ignore the header
            beanReader.configureBeanMapping(Interview.class, FIELD_MAPPING);

            Interview surveyResponse;
            while( (surveyResponse = beanReader.read(Interview.class, processors)) != null ) {
                list.add(surveyResponse);
            }
        }
        finally {
            if( beanReader != null ) {
                beanReader.close();
            }
        }
        return list;
    }


}
