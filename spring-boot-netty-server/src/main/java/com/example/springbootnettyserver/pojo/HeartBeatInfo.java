package com.example.springbootnettyserver.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class HeartBeatInfo implements Serializable {

	private static final long serialVersionUID = 5634457841495229433L;

	private String name;
	private Integer status;

}
