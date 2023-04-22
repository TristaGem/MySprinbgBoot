package com.example.mvc.controller.util;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class R {
    private boolean flag;
    private Object Data;
    public R(boolean flag) {
        this.flag = flag;
    }
}
