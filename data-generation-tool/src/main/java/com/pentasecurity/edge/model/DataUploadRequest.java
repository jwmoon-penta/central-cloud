package com.pentasecurity.edge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class DataUploadRequest extends BaseModel {
	public DataUploadRequest(String deviceId, String data) {
		this.dataInfo = new DataInfo(deviceId, data);
		this.fromType = "device";
		this.fromId = deviceId;
	}

    DataInfo dataInfo;
    String fromType;
    String fromId;
}