package com.ez08.support.util;

import com.ez08.support.net.EzMessage;
import com.ez08.support.net.EzMessageFactory;

import java.util.Vector;

public class EzIntent {
	
	/**
	 * 序列号
	 */
	private int sn;
	/**
	 * 终端号
	 */
	private String tid;

	/**
	 * 用户号
	 */
	private String cid;
	
	/**
	 * 组件名称
	 */
	private String componentName;
	

	/**
	 * Intent Action
	 */
	private String action;
	private int actionID;
	
	/**
	 * Intent URI
	 */
	private String uri;
	
	/**
	 * Intent Category Info
	 */
	private String category;
	
	/**
	 * Intent flags
	 */
	private int flags;

	/**
	 * Intent enc flags
	 * 0:normal,var enc.
	 * 1:package,intent enc.
	 */
	private int encflags;

	/**
	 * Intent Extra Data
	 */
	private Vector<EzKeyValue> extraData;
		

	public EzIntent(String inComponentName,String inAction)
	{
		componentName = inComponentName;
		action = inAction;
		flags = 0;
	}

	/*
	 * inAction
	 */
	public EzIntent(EzMessage intentmsg)
	{
		fromEzMessage(intentmsg);
	}

	/*
	 * inAction
	 */
	public EzIntent(String inAction)
	{
		action = inAction;
		flags = 0;
	}
	/*
	 * bytes
	 */
	public EzIntent(byte[] inBytes)
	{
		fromBytes(inBytes);
	}
	/**
	 * clone 
	 */
	public EzIntent clone()
	{
		return new EzIntent(this.toBytes());
	}
	/**
	 * component name
	 */
	public String getComponentName() {
		return componentName;
	}
	/**
	 * intent name
	 */
	public void setComponentName(String strName) {
		componentName = strName;
	}
	
	/**
	 * action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * action
	 */
	public void setAction(String inAction) {
		action = inAction;
	}
	/**
	 * action id
	 */
	public int getActionID() {
		return actionID;
	}
	/**
	 * action id
	 */
	public void setActionID(int nid) {
		actionID = nid;
	}
	/**
	 * uri
	 */
	public String getURI() {
		return uri;
	}
	/**
	 * uri
	 */
	public void setURI(String inUri) {
		uri = inUri;
	}
	/**
	 * category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * ����category
	 */
	public void setCategory(String inCategory) {
		category = inCategory;
	}
	/**
	 * ��ȡflags
	 */
	public int getFlags() {
		return flags;
	}
	/**
	 * ����flags
	 */
	public void setEncFlags(int inFlags) {
		encflags = inFlags;
	}
	/**
	 * ��ȡflags
	 */
	public int getEncFlags() {
		return encflags;
	}
	/**
	 * ����flags
	 */
	public void setFlags(int inFlags) {
		flags = inFlags;
	}
	/**
	 * gettid
	 */
	public String getTID() {
		return tid;
	}
	/**
	 * settid
	 */
	public void setTID(String inTid) {
		tid = inTid;
	}
	/**
	 * getcid
	 */
	public String getCID() {
		return cid;
	}
	/**
	 * setcid
	 */
	public void setCID(String inCid) {
		cid = inCid;
	}
	/**
	 * ��ȡsn
	 */
	public int getSN() {
		return sn;
	}
	/**
	 * ����sn
	 */
	public void setSN(int inSN) {
		sn = inSN;
	}
	
	/**
	 * ��ȡextra
	 */
	public Vector<EzKeyValue> getExtraData() {
		return extraData;
	}
	/**
	 * ��ȡextra ֵ
	 * @param strName
	 * 		extra ��ݱ������
	 */
	public EzKeyValue getExtraData(String strName) {
		if(extraData == null)
			return null;
		for(int i=0;i<extraData.size();i++)
		{
			EzKeyValue extraVar = extraData.get(i);
			if(extraVar != null)
			{
				if(extraVar.getName().equals(strName))
				{
					return extraVar;
				}
			}
		}
		return null;
	}
	
	/**
	 * @param strName
	 * 		extra
	 */
	public String getExtraDataString(String strName,String defaultValue) {
		if(getExtraData(strName) == null)
			return defaultValue;
		else if(getExtraData(strName).getString() == null)
			return defaultValue;
		else return getExtraData(strName).getString();
	}
	public int getExtraDataInt32(String strName,int defaultValue) {
		if(getExtraData(strName) == null)
			return defaultValue;
		else return getExtraData(strName).getInt32();
	}
	public long getExtraDataInt64(String strName,long defaultValue) {
		if(getExtraData(strName) == null)
			return defaultValue;
		else return getExtraData(strName).getInt64();
	}
	public float getExtraDataFloat(String strName,float defaultValue) {
		if(getExtraData(strName) == null)
			return defaultValue;
		else return getExtraData(strName).getFloat();
	}
	public double getExtraDataDouble(String strName,double defaultValue) {
		if(getExtraData(strName) == null)
			return defaultValue;
		else return getExtraData(strName).getDouble();
	}
	public boolean getExtraDataBoolean(String strName,boolean defaultValue) {
		if(getExtraData(strName) == null)
			return defaultValue;
		else return getExtraData(strName).getBoolean();
	}
	public byte[] getExtraDataBytes(String strName) {
		if(getExtraData(strName) == null)
			return null;
		else return getExtraData(strName).getBytes();
	}
	public String[] getExtraDataStrings(String strName) {
		if(getExtraData(strName) == null)
			return null;
		else return getExtraData(strName).getStrings();
	}
	public EzMessage getExtraDataEzMessage(String strName) {
		if(getExtraData(strName) == null)
			return null;
		else return getExtraData(strName).getMessage();
	}
	public EzMessage[] getExtraDataEzMessages(String strName) {
		if(getExtraData(strName) == null)
			return null;
		else return getExtraData(strName).getMessages();
	}
	public int[] getExtraDataInt32s(String strName) {
		if(getExtraData(strName) == null)
			return null;
		else return getExtraData(strName).getInt32s();
	}
	public long[] getExtraDataInt64s(String strName) {
		if(getExtraData(strName) == null)
			return null;
		else return getExtraData(strName).getInt64s();
	}
	public float[] getExtraDataFloats(String strName) {
		if(getExtraData(strName) == null)
			return null;
		else return getExtraData(strName).getFloats();
	}
	public double[] getExtraDataDoubles(String strName) {
		if(getExtraData(strName) == null)
			return null;
		else return getExtraData(strName).getDoubles();
	}
	public EzKeyValue[] getExtraDataEzKeyValues(String strName) {
		if(getExtraData(strName) == null)
			return null;
		else return getExtraData(strName).getKeyValues();
	}
	public EzValue[] getExtraDataEzValues(String strName) {
		if(getExtraData(strName) == null)
			return null;
		else return getExtraData(strName).getValues();
	}
	
	/**
	 * 
	 */
	public EzKeyValue removeExtra(int index) {
		if( index < 0 || extraData.size() <= index)
			return null;
		return extraData.remove(index);
	}
	
	public EzKeyValue removeExtra(String name) {
		if(name == null || name.isEmpty())
			return null;
		for(int i=0;i<extraData.size();i++)
		{
			EzKeyValue extraVar = extraData.get(i);
			if(extraVar != null)
			{
				if(extraVar.getName().equals(name))
				{
					return extraData.remove(i);
				}
			}
		}
		return null;
	}

	public void putExtraData(EzKeyValue ezVar) {
		if(ezVar == null)
			return;
		if(extraData == null)
			extraData = new Vector<EzKeyValue>();
		//
		for(int i=0;i<extraData.size();i++)
		{
			EzKeyValue extraVar = extraData.get(i);
			if(extraVar != null)
			{
				if(extraVar.getName().equals(ezVar.getName()))
				{
					extraData.set(i, ezVar);
					return;
				}
			}
		}
		//
		extraData.add(ezVar);
	}

	/*
	 * 转成message
	 */
	public EzMessage toEzMessage()
	{
		EzMessage msg = EzMessageFactory.CreateMessageObject("msg.intent");
		if(msg != null)
		{
			msg.getKVData("sn").setValue(sn);		
			if(tid != null)
				msg.getKVData("tid").setValue(tid);		
			if(cid != null)
				msg.getKVData("cid").setValue(cid);		
			if(action != null)
				msg.getKVData("action").setValue(action);		
			if(componentName != null)
				msg.getKVData("componentname").setValue(componentName);		
			if(uri != null)
				msg.getKVData("uri").setValue(uri);		
			if(category != null)
				msg.getKVData("category").setValue(category);
			msg.getKVData("flags").setValue(flags);
			msg.getKVData("encflags").setValue(encflags);
			msg.getKVData("actionid").setValue(encflags);
			if(extraData != null && extraData.size()>0)
			{
				EzKeyValue[] values = new EzKeyValue[extraData.size()];
				this.extraData.toArray(values);
				msg.getKVData("extra").setValue(values);
			}
			return msg;
		}
		else
			return null;
	}

	/*
	 * 转自message
	 */
	public boolean fromEzMessage(EzMessage msg)
	{
		if(msg != null)
		{
			sn = msg.getKVData("sn").getInt32();
			tid = msg.getKVData("tid").getString();
			cid = msg.getKVData("cid").getString();
			action = msg.getKVData("action").getString();
			componentName = msg.getKVData("componentname").getString();
			uri = msg.getKVData("uri").getString();
			category = msg.getKVData("category").getString();
			flags = msg.getKVData("flags").getInt32();
			encflags = msg.getKVData("encflags").getInt32();
			actionID = msg.getKVData("actionid").getInt32();
			EzKeyValue[] kvs = msg.getKVData("extra").getKeyValues();
			if(kvs != null)
			{
				if(extraData == null)
					extraData = new Vector<EzKeyValue>();
				for(int i=0;i<kvs.length;i++)
				{
					if(kvs[i]!=null)
						extraData.add(kvs[i]);
				}
			}
			return true;
		}
		else
			return false;
	}

	/**
	 * to bytes
	 */
	public byte[] toBytes()
	{
		EzMessage msg = toEzMessage();
		if(msg != null)
		{
			return msg.serializeToPB();
		}
		else
			return null;
	}
	/**
	 * from Bytes
	 */
	public boolean fromBytes(byte[] inBytes)
	{
		EzMessage msg = EzMessageFactory.CreateMessageObject(inBytes);
		if(msg != null)
		{	
			return fromEzMessage(msg);
		}
		else
			return false;
	}
}
