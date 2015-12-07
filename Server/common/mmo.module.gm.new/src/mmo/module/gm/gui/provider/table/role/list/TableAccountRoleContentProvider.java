package mmo.module.gm.gui.provider.table.role.list;

import java.util.List;

import mmo.module.gm.bean.AccountRole;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class TableAccountRoleContentProvider implements IStructuredContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {
		return ((List<AccountRole>) inputElement).toArray();
	}

	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {

	}

}
