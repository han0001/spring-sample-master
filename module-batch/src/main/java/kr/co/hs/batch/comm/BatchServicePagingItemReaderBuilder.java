package kr.co.hs.batch.comm;


import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

public class BatchServicePagingItemReaderBuilder<T> {

    private Object batchService;

    private String methodName;

    private Object[] arguments;

    private int pageSize = 10;

    private boolean saveState = true;

    private String name = ClassUtils.getShortName(BatchServicePagingItemReader.class);

    private int maxItemCount = Integer.MAX_VALUE;

    private int currentItemCount;

    public BatchServicePagingItemReaderBuilder<T> batchService(Object batchService) {
        this.batchService = batchService;

        return this;
    }

    public BatchServicePagingItemReaderBuilder<T> methodName(String methodName) {
        this.methodName = methodName;

        return this;
    }

    public BatchServicePagingItemReaderBuilder<T> arguments(Object... arguments) {
        this.arguments = arguments;

        return this;
    }

    public BatchServicePagingItemReaderBuilder<T> pageSize(int pageSize) {
        this.pageSize = pageSize;

        return this;
    }

    public BatchServicePagingItemReaderBuilder<T> saveState(boolean saveState) {
        this.saveState = saveState;

        return this;
    }

    public BatchServicePagingItemReaderBuilder<T> name(String name) {
        this.name = name;

        return this;
    }

    public BatchServicePagingItemReaderBuilder<T> maxItemCount(int maxItemCount) {
        this.maxItemCount = maxItemCount;

        return this;
    }

    public BatchServicePagingItemReaderBuilder<T> currentItemCount(int currentItemCount) {
        this.currentItemCount = currentItemCount;

        return this;
    }

    public BatchServicePagingItemReader<T> build() {
        Assert.notNull(batchService, "batchService는 필수");
        Assert.hasText(methodName, "methodName은 필수");
        if (saveState) {
            Assert.state(StringUtils.hasText(name), "saveState가 true면 name은 필수");
        }

        BatchServicePagingItemReader<T> reader = new BatchServicePagingItemReader<>();
        reader.setBatchService(batchService);
        reader.setMethodName(methodName);
        reader.setArguments(arguments);
        reader.setPageSize(pageSize);
        reader.setSaveState(saveState);
        reader.setName(name);
        reader.setMaxItemCount(maxItemCount);
        reader.setCurrentItemCount(currentItemCount);

        return reader;
    }

}
