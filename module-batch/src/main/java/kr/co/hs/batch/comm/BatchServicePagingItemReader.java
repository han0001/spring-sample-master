package kr.co.hs.batch.comm;


import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.database.AbstractPagingItemReader;
import org.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class BatchServicePagingItemReader<T> extends AbstractPagingItemReader<T> {

    private BatchServiceReadingAdapter<T> readingAdapter;

    private Object batchService;

    private String methodName;

    private final List<Object> arguments = new ArrayList<>();

    public BatchServicePagingItemReader() {
        setName(ClassUtils.getShortName(BatchServicePagingItemReader.class));
    }

    public void setBatchService(Object batchService) {
        this.batchService = batchService;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setArguments(Object... arguments) {
        this.arguments.addAll(Arrays.asList(arguments));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();

        readingAdapter = new BatchServiceReadingAdapter<>();
        readingAdapter.setTargetObject(batchService);
        readingAdapter.setTargetMethod(methodName);
    }

    @Override
    protected void doReadPage() {
        if (results == null) {
            results = new CopyOnWriteArrayList<>();
        }
        else {
            results.clear();
        }

        List<T> batchServiceResults;
        try {
            batchServiceResults = readingAdapter.invoke(pagedArguments());
            results.addAll(batchServiceResults);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

    private List<Object> pagedArguments() {
        var pagedArguments = new ArrayList<>(arguments);
        pagedArguments.add(getPage());
        pagedArguments.add(getPageSize());

        return pagedArguments;
    }

}
