package eleven.m_complete.com.eleven.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*** added by dPLayer
 */
@Entity
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int number;
	private String name;
	private String pass;
	public Player() {
	}
	public Player(Long id, int number, String name, String pass) {
		this.id = id;
		this.number = number;
		this.name = name;
		this.pass = pass;
	}
	public int getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public String getPass() {
		return pass;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		int hash = 0;
		hash +=(id != null ? id.hashCode() : 0);
		return hash;
	}
	@Override
	public boolean equals(Object object) {
		if(!(object instanceof Player)) {
			return false;
		}
		Player other = ( Player ) object;
		if((this.id == null && other.id != null) ||(this.id != null && !
				this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "com.eleven.model.Player[ id=" + id + " ]";
	}
}