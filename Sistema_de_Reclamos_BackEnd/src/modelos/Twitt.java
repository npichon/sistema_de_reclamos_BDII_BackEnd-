package modelos;

/**
 * @author Nahuel
 *
 */
public class Twitt {
	protected String idTwitter;
	protected String cuentaTwitter;
	protected String hashtag;
	protected String contenido;

	public Twitt() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Twitt(String idTwitter, String cuentaTwitter, String hashtag,
			String contenido) {
		super();
		this.idTwitter = idTwitter;
		this.cuentaTwitter = cuentaTwitter;
		this.hashtag = hashtag;
		this.contenido = contenido;
	}

	public String getIdTwitter() {
		return idTwitter;
	}

	public void setIdTwitter(String idTwitter) {
		this.idTwitter = idTwitter;
	}

	public String getCuentaTwitter() {
		return cuentaTwitter;
	}

	public void setCuentaTwitter(String cuentaTwitter) {
		this.cuentaTwitter = cuentaTwitter;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

}
