package kr.co.hs.batch.comm;


import org.springframework.batch.item.adapter.AbstractMethodInvokingDelegator;

import java.util.List;

public class BatchServiceReadingAdapter<T> extends AbstractMethodInvokingDelegator<List<T>> {

    public List<T> invoke(List<Object> arguments) throws Exception {
        return invokeDelegateMethodWithArguments(arguments.toArray());
    }

}
