package com.ashu16.microservice.limitsservice.beans;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Setter
@Getter
public class UserDeatils {
    private String username;
    private String pw;

}
