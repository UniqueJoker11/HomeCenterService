package colin.app.core.pojo;
import javax.persistence.*;

/**
 * Created by joker on 15-2-16.
 * POJO类 CommentEntity
 */
@Entity
@Table(name="comment")
public class CommentEntity{

/*
 * 用户评论Id
*/
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name ="comment_id")
private int comment_id;

/*
 * 用户评论内容
*/
@Column(name ="comment_content")
private String comment_content;

/*
 * 评论作者
*/
@Column(name ="comment_author")
private String comment_author;

/*
 * 评论作者id
*/
@Column(name ="comment_aticleId")
private int comment_aticleId;

/*
 * 评论日期
*/
@Column(name ="comment_date")
private String comment_date;


public void setComment_id(int comment_id){
this.comment_id=comment_id;
}
public int getComment_id(){
return this.comment_id;
}

public void setComment_content(String comment_content){
this.comment_content=comment_content;
}
public String getComment_content(){
return this.comment_content;
}

public void setComment_author(String comment_author){
this.comment_author=comment_author;
}
public String getComment_author(){
return this.comment_author;
}

public void setComment_aticleId(int comment_aticleId){
this.comment_aticleId=comment_aticleId;
}
public int getComment_aticleId(){
return this.comment_aticleId;
}

public void setComment_date(String comment_date){
this.comment_date=comment_date;
}
public String getComment_date(){
return this.comment_date;
}

}
