package colin.app.core.pojo;
import javax.persistence.*;

/**
 * Created by joker on 15-2-16.
 * POJO类 WhisperEntity
 */
@Entity
@Table(name="whisper")
public class WhisperEntity{

/*
 * whisper_id
*/
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name ="whisper_id")
private int whisper_id;

/*
 * 悄悄话
*/
@Column(name ="whisper_content")
private String whisper_content;

/*
 * 创建时间
*/
@Column(name ="create_time")
private String create_time;

/*
 * 创建人
*/
@Column(name ="create_user")
private String create_user;


public void setWhisper_id(int whisper_id){
this.whisper_id=whisper_id;
}
public int getWhisper_id(){
return this.whisper_id;
}

public void setWhisper_content(String whisper_content){
this.whisper_content=whisper_content;
}
public String getWhisper_content(){
return this.whisper_content;
}

public void setCreate_time(String create_time){
this.create_time=create_time;
}
public String getCreate_time(){
return this.create_time;
}

public void setCreate_user(String create_user){
this.create_user=create_user;
}
public String getCreate_user(){
return this.create_user;
}

}
