package pages.djini;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    @Builder.Default
    private String email = "tsibatyuk@gmail.com";
    @Builder.Default
    private String pass = "zheka1987";
}
