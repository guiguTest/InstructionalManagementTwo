package com.guigu.marketactive.transfor;

import org.displaytag.decorator.ColumnDecorator;
import org.displaytag.exception.DecoratorException;
public class TransforType implements ColumnDecorator{

	@Override
	public String decorate(Object state) throws DecoratorException {
		Integer st=(Integer) state;
		if(st==0) {
			return "�ֳ�����";
		}
		else if(st==1) {
			return "����";
		}
		else {
			return "����";
		}
	}

}
