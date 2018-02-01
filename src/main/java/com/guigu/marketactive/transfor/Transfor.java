package com.guigu.marketactive.transfor;

import org.displaytag.decorator.ColumnDecorator;
import org.displaytag.exception.DecoratorException;
public class Transfor implements ColumnDecorator{

	@Override
	public String decorate(Object state) throws DecoratorException {
		Integer st=(Integer) state;
		if(st==0) {
			return "׼����";
		}
		if (st==1) {
			return "��ʼ";
		}
		if (st==2) {
			return "������";
		}else {
			return "�ѽ���";
		}
		
	}

}
