package eleven.m_complete.com.eleven.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
/*** added by dTeam
 */
@Entity
public class Team implements Serializable {
	@OneToMany(mappedBy = "team1")
	private List<EMatch> eMatchs;
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@OneToMany
	private List<Player> teamPlayers;
	public List<EMatch> geteMatchs() {
		return eMatchs;
	}
	public void seteMatchs(List<EMatch> eMatchs) {
		this.eMatchs = eMatchs;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Player> getTeamPlayers() {
		return teamPlayers;
	}
	public void setTeamPlayers(List<Player> teamPlayers) {
		this.teamPlayers = teamPlayers;
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
		if(!(object instanceof Team)) {
			return false;
		}
		Team other = ( Team ) object;
		if((this.id == null && other.id != null) ||(this.id != null && !
				this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "com.eleven.model.Team[ id=" + id + " ]";
	}
}