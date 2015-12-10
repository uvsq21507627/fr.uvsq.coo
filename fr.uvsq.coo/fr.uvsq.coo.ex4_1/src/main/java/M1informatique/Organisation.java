package M1informatique;

import java.io.Serializable;

public interface Organisation extends Serializable {
	public void afficher(int mode);
	public void save();
	public Organisation load() throws Exception;
}
