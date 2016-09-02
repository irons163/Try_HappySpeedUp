package com.example.try_happyspeedup.utils;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;

import com.example.try_gameengine.framework.CommonUtil;
import com.example.try_happyspeedup.R;

public class BitmapUtil {
	static Context context;
	
public static Bitmap bar;
	public static Bitmap s0,s1,s2,s3,s4,s5,s6,s7,s8,s9,dot;
	public static Bitmap yellow_point,bg01_green,wing;
	public static float sreenWidth;

	public static float sreenHeight;
	public static float PLAYER_WIDTH_PERSENT;
	public static int TOOL_WIDTH_PERSENT;
	public static int FIREBALL_WIDTH_PERSENT;

	public static Bitmap wall_bitmap;
	public static PointF wall_size;
	public static Bitmap speedup_bitmap;
	public static PointF speedup_size;
	public static Bitmap speeddown_bitmap;
	public static PointF speeddown_size;
	public static Bitmap fly_bitmap;
	public static PointF fly_size;
	public static Bitmap btn_GameCenter_hd;
	public static Bitmap btn_Music_hd;
	public static Bitmap btn_Music_Select_hd;
	public static Bitmap hamster;
	
//	public Bitmap * tool_bomb_bitmap;
//	public Bitmap * toll_cure_bitmap;
//	public Bitmap * tool_bomb_explosion_bitmap;
//	public Bitmap * toll_eat_man_tree_bitmap;
//	public Bitmap * toll_eat_man_tree2_bitmap;
//	public Bitmap * toll_eat_man_tree3_bitmap;
//	public Bitmap * fire_ball;


	public Bitmap[] numberImageArray;
	
	public static void initBitmap(Context context){
		BitmapUtil.context = context;
//		initBitmap();
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inSampleSize = 1;
		options.inJustDecodeBounds = false;
		
//		s0 = BitmapFactory.decodeResource(context.getResources(), R.drawable.s0);
//		s1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.s1);
//		s2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.s2);
//		s3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.s3);
//		s4 = BitmapFactory.decodeResource(context.getResources(), R.drawable.s4);
//		s5 = BitmapFactory.decodeResource(context.getResources(), R.drawable.s5);
//		s6 = BitmapFactory.decodeResource(context.getResources(), R.drawable.s6);
//		s7 = BitmapFactory.decodeResource(context.getResources(), R.drawable.s7);
//		s8 = BitmapFactory.decodeResource(context.getResources(), R.drawable.s8);
//		s9 = BitmapFactory.decodeResource(context.getResources(), R.drawable.s9);
//		dot = BitmapFactory.decodeResource(context.getResources(), R.drawable.dot);
//		
		yellow_point = BitmapFactory.decodeResource(context.getResources(), R.drawable.yellow_point);
		bg01_green = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg01_green);
		wing = BitmapFactory.decodeResource(context.getResources(), R.drawable.wing);
		
        PLAYER_WIDTH_PERSENT = 2.5f;
        TOOL_WIDTH_PERSENT = 4;
        FIREBALL_WIDTH_PERSENT = 3;
        
        sreenWidth = 300.0f;
        sreenHeight = 600.0f;
        
        float footbarWidth = sreenWidth / 3;
        float playerWidth = footbarWidth /PLAYER_WIDTH_PERSENT;
        float toolWidth = footbarWidth / TOOL_WIDTH_PERSENT;
        float fireballWidth = footbarWidth /FIREBALL_WIDTH_PERSENT;
        
        wall_bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.f1_hd);
        wall_size = new PointF(playerWidth, (int)((float)wall_bitmap.getHeight()/wall_bitmap.getWidth() * playerWidth));
        
        speedup_bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.boots);
        speedup_size = new PointF(playerWidth, (int)((float)speedup_bitmap.getHeight()/ speedup_bitmap.getWidth() * playerWidth));
        speeddown_bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.bubble_1);
        speeddown_size = new PointF(playerWidth, (int)((float)speeddown_bitmap.getHeight()/ speeddown_bitmap.getWidth() * playerWidth));
        fly_bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.wing);
        fly_size = new PointF(playerWidth, (int)((float)fly_bitmap.getHeight()/ fly_bitmap.getWidth() * playerWidth));
        
        btn_GameCenter_hd = BitmapFactory.decodeResource(context.getResources(), R.drawable.btn_gamecenter_hd);
        btn_Music_hd = BitmapFactory.decodeResource(context.getResources(), R.drawable.btn_music_hd);
        btn_Music_Select_hd = BitmapFactory.decodeResource(context.getResources(), R.drawable.btn_music_select_hd);
        hamster = BitmapFactory.decodeResource(context.getResources(), R.drawable.hamster);
//        hamster = createSpecificSizeBitmap(context.getResources().getDrawable(R.drawable.hamster), 336, 100);
//        numberImageArray = [NSArray arrayWithObjects:[UIImage imageNamed:@"s0"], [UIImage imageNamed:@"s1"], [UIImage imageNamed:@"s2"], [UIImage imageNamed:@"s3"], [UIImage imageNamed:@"s4"], [UIImage imageNamed:@"s5"], [UIImage imageNamed:@"s6"], [UIImage imageNamed:@"s7"], [UIImage imageNamed:@"s8"], [UIImage imageNamed:@"s9"], nil];
	}
	
	public static void resizeToolBmp(){
		
	}
	
	public static Bitmap createSpecificSizeBitmap(Drawable drawable, int width, int height) {
		
		Bitmap bitmap = Bitmap.createBitmap(width, height,
				Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap); 
		drawable.setBounds(0, 0, width, height);
		drawable.draw(canvas); 
		return bitmap;
	}
	
	public static Bitmap getBitmap(String path) {
		try {
			InputStream is = context.getAssets().open(path);

			return BitmapFactory.decodeStream(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Bitmap getBitmapFromRes(int resId){
		Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resId);
		return bitmap;
	}
	
	public static Bitmap createBitmap(Bitmap bmp, float scale){
		
		Matrix matrix = new Matrix(); 
		
		matrix.postScale(scale, scale); 
			
		Bitmap resizeBmp = Bitmap.createBitmap(bmp,0,0,bmp.getWidth(), 
		
				bmp.getHeight(),matrix,true);
		return resizeBmp; 
	}
	
	public static void createTimeCounterBitmap(int w, int h){
		float scaleX, scaleY, scale; 
		scaleX = (float)w/s0.getWidth();
		scaleY = (float)h/s0.getHeight();
		
		scale = scaleX < scaleY ? scaleX : scaleY;
		
		s0 = createBitmap(s0, scale);
		s1 = createBitmap(s1, scale);
		s2 = createBitmap(s2, scale);
		s3 = createBitmap(s3, scale);
		s4 = createBitmap(s4, scale);
		s5 = createBitmap(s5, scale);
		s6 = createBitmap(s6, scale);
		s7 = createBitmap(s7, scale);
		s8 = createBitmap(s8, scale);
		s9 = createBitmap(s9, scale);
		dot = createBitmap(dot, scale);

	}
	
}
