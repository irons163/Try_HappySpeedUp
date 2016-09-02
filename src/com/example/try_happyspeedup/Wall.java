package com.example.try_happyspeedup;

import com.example.try_gameengine.framework.Sprite;
import com.example.try_happyspeedup.utils.CommonUtil;

public class Wall extends Sprite{
	
	public Wall(float x, float y, boolean autoAdd) {
		super(x, y, autoAdd);
		// TODO Auto-generated constructor stub
	}

	public boolean isNeedCreateNewInstance(){
	    boolean isNeedCreateNewInstance = false;
//	    if(this.getY() >= 50){
	    if(this.getTop() <= CommonUtil.screenHeight-50){
	        isNeedCreateNewInstance = true;
	    }
	    return isNeedCreateNewInstance;
	}

	public boolean isNeedRemoveInstance(){
	    boolean isNeedRemoveInstance = false;
//	    if(this.getY() >= CommonUtil.screenHeight){
	    if(this.getTop() >= CommonUtil.screenHeight){
	        isNeedRemoveInstance = true;
	    }
	    return isNeedRemoveInstance;
	}

	public void move(){
	    this.setY(this.getY()-3);
	}

	public void move(float speedY){
	    this.setY(this.getY()-speedY);
	}
}
