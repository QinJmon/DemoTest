package com.openbayes.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeletionStatus {
    private Boolean success;

    public static Builder newBuilder(){
        return new Builder();
    }
    public static class Builder{
        private boolean success;

        public DeletionStatus build(){
            DeletionStatus result = new DeletionStatus();
            result.success=this.success;
            return result;
        }

        public Builder success(boolean success){
            this.success=success;
            return this;
        }
    }
}
