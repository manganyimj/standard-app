package test.example.TestApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PokemanResponse implements Serializable {

        private Integer count;
        private String next;
        private Object previous;
        private List<test.example.TestApp.model.Result> results = null;

}
