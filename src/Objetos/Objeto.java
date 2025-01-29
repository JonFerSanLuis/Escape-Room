package Objetos;

public class Objeto {
	private Boolean inspeccionable;
	private Boolean usable;
	private Integer ObjId;
	private String ObjName;
	private String ObjDescrip;
	
	public Objeto(Boolean inspeccionable, Boolean usable, Integer objId, String objName, String objDescrip) {
		super();
		this.inspeccionable = inspeccionable;
		this.usable = usable;
		ObjId = objId;
		ObjName = objName;
		ObjDescrip = objDescrip;
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
	
}
