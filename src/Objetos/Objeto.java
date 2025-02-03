package Objetos;

public class Objeto {
	private Boolean inspeccionable;
	private Boolean usable;
	private Integer ObjId;
	private String ObjName;
	private String ObjDescrip;
	private String FileName;
	
	public Objeto(Boolean inspeccionable, Boolean usable, Integer objId, String objName, String objDescrip, String fileName) {
		super();
		this.inspeccionable = inspeccionable;
		this.usable = usable;
		ObjId = objId;
		ObjName = objName;
		ObjDescrip = objDescrip;
		FileName = fileName;
	}

	public Boolean getInspeccionable() {
		return inspeccionable;
	}

	public void setInspeccionable(Boolean inspeccionable) {
		this.inspeccionable = inspeccionable;
	}

	public Boolean getUsable() {
		return usable;
	}

	public void setUsable(Boolean usable) {
		this.usable = usable;
	}

	public Integer getObjId() {
		return ObjId;
	}

	public void setObjId(Integer objId) {
		ObjId = objId;
	}

	public String getObjName() {
		return ObjName;
	}

	public void setObjName(String objName) {
		ObjName = objName;
	}
	
	public String getObjDescrip() {
		return ObjDescrip;
	}

	public void setObjDescrip(String objDescrip) {
		ObjName = objDescrip;
	}
	
	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Objeto objeto = (Objeto) obj;
        return ObjName.equals(objeto.ObjName);
    }
	
}
