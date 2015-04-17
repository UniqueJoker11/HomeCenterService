package colin.app.core.pojo;
import javax.persistence.*;

/**
 * Created by joker on 15-2-16.
 * POJO类 BrowserEntity
 */
@Entity
@Table(name="browser")
public class BrowserEntity{

/*
 * 浏览id
*/
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name ="browser_id")
private int browser_id;

/*
 * 浏览文章数量
*/
@Column(name ="browser_num")
private int browser_num;

/*
 * 浏览文章id
*/
@Column(name ="browser_aticleId")
private int browser_aticleId;


public void setBrowser_id(int browser_id){
this.browser_id=browser_id;
}
public int getBrowser_id(){
return this.browser_id;
}

public void setBrowser_num(int browser_num){
this.browser_num=browser_num;
}
public int getBrowser_num(){
return this.browser_num;
}

public void setBrowser_aticleId(int browser_aticleId){
this.browser_aticleId=browser_aticleId;
}
public int getBrowser_aticleId(){
return this.browser_aticleId;
}

}
