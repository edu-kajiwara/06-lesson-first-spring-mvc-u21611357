package tama.ac.jp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by kajiwarayutaka on 2017/05/09.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String user_id;
    private String user_name;
}
