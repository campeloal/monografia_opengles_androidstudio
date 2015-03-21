package shaders;

import graphics.shaders.R;

import java.nio.FloatBuffer;
import java.util.Hashtable;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import android.os.Build;

@TargetApi(Build.VERSION_CODES.FROYO) public class RandColorShader extends Shader{

	private static final int FLOAT_SIZE_BYTES = 4;
	private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 8 * FLOAT_SIZE_BYTES;
	private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
	private int uMVPMatrix;
	private int aPositionAddr;

	public RandColorShader()
	{
		super.vID = R.raw.randcolor_vs;
		super.fID = R.raw.randcolor_ps;
	}

	@Override
	public void getParamsLocations() {
		uMVPMatrix = GLES20.glGetUniformLocation(_program, "uMVPMatrix");	
		aPositionAddr = GLES20.glGetAttribLocation(_program, "aPosition");
	}

	@Override
	public void initShaderParams(@SuppressWarnings("rawtypes") Hashtable shaderParams) {
		GLES20.glUniformMatrix4fv(uMVPMatrix, 1, false, (float[]) shaderParams.get("mMVPMatrix"), 0);
		// the vertex coordinates
		((FloatBuffer) shaderParams.get("vertex buffer")).position(TRIANGLE_VERTICES_DATA_POS_OFFSET);
		GLES20.glVertexAttribPointer(aPositionAddr, 3, GLES20.GL_FLOAT, false,
				TRIANGLE_VERTICES_DATA_STRIDE_BYTES, ((FloatBuffer) shaderParams.get("vertex buffer")));
		GLES20.glEnableVertexAttribArray(aPositionAddr);
		
	}

}