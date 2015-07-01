package colin.app.core.pojo;
import javax.persistence.*;

/**
 * Created by joker on 15-2-16.
 * POJO类 MusicEntity
 */
@Entity
@Table(name="music")
public class MusicEntity{

/*
 * whisper_id
*/
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name ="music_id")
private int music_id;

/*
 * 歌曲名
*/
@Column(name ="music_name")
private String music_name;

/*
 * 演唱者
*/
@Column(name ="music_author")
private String music_author;

/*
 * 歌曲封面
*/
@Column(name ="music_cover")
private String music_cover;

/*
 * 播放次数
*/
@Column(name ="music_play_num")
private int music_play_num;

/*
 * 音乐播放链接
*/
@Column(name ="music_link")
private String music_link;

/*
 * 音乐分类
*/
@Column(name ="music_category")
private String music_category;

/*
 * 音乐描述
*/
@Column(name ="music_describe")
private String music_describe;

/*
 * 歌曲创建时间
*/
@Column(name ="music_time")
private String music_time;

/*
 * 歌曲创建人
*/
@Column(name ="create_user")
private String create_user;


public void setMusic_id(int music_id){
this.music_id=music_id;
}
public int getMusic_id(){
return this.music_id;
}

public void setMusic_name(String music_name){
this.music_name=music_name;
}
public String getMusic_name(){
return this.music_name;
}

public void setMusic_author(String music_author){
this.music_author=music_author;
}
public String getMusic_author(){
return this.music_author;
}

public void setMusic_cover(String music_cover){
this.music_cover=music_cover;
}
public String getMusic_cover(){
return this.music_cover;
}

public void setMusic_play_num(int music_play_num){
this.music_play_num=music_play_num;
}
public int getMusic_play_num(){
return this.music_play_num;
}

public void setMusic_link(String music_link){
this.music_link=music_link;
}
public String getMusic_link(){
return this.music_link;
}

public void setMusic_category(String music_category){
this.music_category=music_category;
}
public String getMusic_category(){
return this.music_category;
}

public void setMusic_describe(String music_describe){
this.music_describe=music_describe;
}
public String getMusic_describe(){
return this.music_describe;
}

public void setMusic_time(String music_time){
this.music_time=music_time;
}
public String getMusic_time(){
return this.music_time;
}

public void setCreate_user(String create_user){
this.create_user=create_user;
}
public String getCreate_user(){
return this.create_user;
}

}
