package com.neusoft.fruitvegemis.datapool;

import com.neusoft.fruitvegemis.persistence.Entity;

public class OrderRecord extends Entity {
	public final String oid;
	public final String sname;
	public final String gname;
	public final float gprice;
	public final byte[] gpicture;

	public OrderRecord(String _oid, String _sname, String _gname,
			float _gprice, byte[] _gpicture) {
		this.oid = _oid;
		this.sname = _sname;
		this.gname = _gname;
		this.gprice = _gprice;
		this.gpicture = _gpicture;
	}
}
