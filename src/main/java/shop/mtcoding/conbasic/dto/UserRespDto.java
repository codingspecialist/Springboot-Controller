package shop.mtcoding.conbasic.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRespDto {
    private int id;
    private String username;
    // password는 응답하지 않음.
    private String tel;

    public UserRespDto(int id, String username, String tel) {
        this.id = id;
        this.username = username;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "UserRespDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
