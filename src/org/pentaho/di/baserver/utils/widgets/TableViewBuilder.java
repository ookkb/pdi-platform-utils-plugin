/*
 * This program is free software; you can redistribute it and/or modify it under the
 * terms of the GNU General Public License, version 2 as published by the Free Software
 * Foundation.
 *
 * You should have received a copy of the GNU General Public License along with this
 * program; if not, you can obtain a copy at http://www.gnu.org/licenses/gpl-2.0.html
 * or from the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 *
 * Copyright 2006 - 2015 Pentaho Corporation.  All rights reserved.
 */

package org.pentaho.di.baserver.utils.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.pentaho.di.core.variables.VariableSpace;
import org.pentaho.di.ui.core.PropsUI;
import org.pentaho.di.ui.core.widget.ColumnInfo;
import org.pentaho.di.ui.core.widget.TableView;

import java.util.ArrayList;

public final class TableViewBuilder extends WidgetBuilder<TableView> {

  private VariableSpace variableSpace;
  private ArrayList<ColumnInfo> columns = new ArrayList<ColumnInfo>();
  private int rowsCount = 0;
  private ModifyListener modifyListener = null;

  public TableViewBuilder( PropsUI props, Composite parent, VariableSpace variableSpace ) {
    super( parent, props );
    this.variableSpace = variableSpace;
  }

  public TableViewBuilder addColumnInfo( ColumnInfo columnInfo ) {
    this.columns.add( columnInfo );
    return this;
  }

  public TableViewBuilder setRowsCount( int rowsCount ) {
    this.rowsCount = rowsCount;
    return this;
  }

  public TableViewBuilder setModifyListener( ModifyListener modifyListener ) {
    this.modifyListener = modifyListener;
    return this;
  }

  @Override
  protected TableView createWidget( Composite parent ) {
    // create table view
    ColumnInfo[] columnsArray = columns.toArray( new ColumnInfo[ columns.size() ] );
    TableView tableView = new TableView( this.variableSpace, this.parent, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI,
      columnsArray, this.rowsCount, this.modifyListener, this.props );
    return tableView;
  }
}
