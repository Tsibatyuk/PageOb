package utiles;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    @Builder.Default
    private String email = "jngbbnfjbnljf";
    @Builder.Default
    private String password = "12345";
}
