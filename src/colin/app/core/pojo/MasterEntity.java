package colin.app.core.pojo;
import javax.persistence.*;

/**
 * Created by joker on 15-2-16.
 * POJO类 MasterEntity
 */
@Entity
@Table(name="master")
public class MasterEntity{

/*
 * master_id
*/
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name ="master_id")
private int master_id;

/*
 * 博主姓名
*/
@Column(name ="master_name")
private String master_name;

/*
 * 博主头像
*/
@Column(name ="master_header")
private String master_header;

/*
 * 博主介绍
*/
@Column(name ="master_introduce")
private String master_introduce;

/*
 * 博主座右铭
*/
@Column(name ="master_words")
private String master_words;

/*
 * 博主职业
*/
@Column(name ="master_carrer")
private String master_carrer;


public void setMaster_id(int master_id){
this.master_id=master_id;
}
public int getMaster_id(){
return this.master_id;
}

public void setMaster_name(String master_name){
this.master_name=master_name;
}
public String getMaster_name(){
return this.master_name;
}

public void setMaster_header(String master_header){
this.master_header=master_header;
}
public String getMaster_header(){
return this.master_header;
}

public void setMaster_introduce(String master_introduce){
this.master_introduce=master_introduce;
}
public String getMaster_introduce(){
return this.master_introduce;
}

public void setMaster_words(String master_words){
this.master_words=master_words;
}
public String getMaster_words(){
return this.master_words;
}

public void setMaster_carrer(String master_carrer){
this.master_carrer=master_carrer;
}
public String getMaster_carrer(){
return this.master_carrer;
}

}
