package shop.mtcoding.conbasic.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardRespDto {
    private int id;
    private String title;
    private String content;

    public BoardRespDto(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
