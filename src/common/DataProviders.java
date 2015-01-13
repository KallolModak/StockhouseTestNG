/*
*This class will used to pass parameter to test methods via DataProviders of TestNg
*/
package common;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "reportFormat")
	public  static Object[][] reportFormat(){

		return new Object[][]{new String[]{"ACROBAT PDF"},{"HTML"},{"JVISTA"},{"iHTML"}};
	}
	@DataProvider(name = "viewerToolbar")
	public static Object[][] viewerToolbar(){

		return new Object[][]{new String[]{"No"},{"Yes"},{"On Multipage"}};
	}
	@DataProvider(name = "adhocToolbar")
	public static Object[][] adhocToolbar(){

		return new Object[][]{new String[]{"No"},{"Yes"},{"Yes, Expanded"}};
	}
	@DataProvider(name = "adhocToolbarTabs")
	public static Object[][] adhocToolbarTabs(){

		return new Object[][]{new String[]{"Yes","(Default)"},new String[]{"Yes","Fields"},new String[]{"Yes","Filter"},new String[]{"Yes","Group"},new String[]{"Yes","Total"},new String[]{"Yes","Sort"},new String[]{"Yes","Highlight"},new String[]{"Yes","Matrix"},new String[]{"Yes","Chart"},new String[]{"Yes","Network Graph"},new String[]{"Yes","Map"},
				new String[]{"Yes, Expanded","(Default)"},new String[]{"Yes, Expanded","Fields"},new String[]{"Yes, Expanded","Filter"},new String[]{"Yes, Expanded","Group"},new String[]{"Yes, Expanded","Total"},new String[]{"Yes, Expanded","Sort"},new String[]{"Yes, Expanded","Highlight"},new String[]{"Yes, Expanded","Matrix"},new String[]{"Yes, Expanded","Chart"},new String[]{"Yes, Expanded","Network Graph"},new String[]{"Yes, Expanded","Map"} };
	}
	@DataProvider(name = "parameterToolbar")
	public static Object[][] parameterToolbar(){

		return new Object[][]{new String[]{"No"},{"Yes"},{"Yes, Expanded"}};
	}
	@DataProvider(name = "showScrollbar")
	public static Object[][] showScrollbar(){

		return new Object[][]{new String[]{"No"},{"Yes"}};
	}
	@DataProvider(name = "autoRefresh")
	public static Object[][] autoRefresh(){

		return new Object[][]{new String[]{"No"},{"Yes"}};
	}
	@DataProvider(name = "heightWidth")
	public static Object[][] heightWidth(){

		return new Object[][]{new String[]{"10"},{"20"}};
	}
	//For Link widget
	@DataProvider(name = "linkAutoRefresh")
	public static Object[][] linkAutoRefresh(){

		return new Object[][]{new String[]{"No"},{"Yes"}};
	}
	@DataProvider(name = "linkWidgetheightWidth")
	public static Object[][] linkWidgetheightWidth(){

		return new Object[][]{new String[]{"10"},{"20"}};
	}
	@DataProvider(name="InstanceNavigation")
	public static Object[][] instanceNavigation(){
		return new Object[][]{new String[]{"No"},{"Yes"}};
	}
  //For OLAP widget
	@DataProvider(name="ViewMode")
	public static Object[][] viewMode(){
		return new Object[][]{new String[]{"Default"},{"Grid"},{"Chart"},{"Dual"}};
	}
	@DataProvider(name="DataActions")
	public static Object[][] dataActions(){
		return new Object[][]{new String[]{"No"},{"Yes"}};
	}
	@DataProvider(name="ViewActions")
	public static Object[][] viewActions(){
		return new Object[][]{new String[]{"No"},{"Yes"}};
	}
	@DataProvider(name="LayoutActions")
	public static Object[][] layoutActions(){
		return new Object[][]{new String[]{"No"},{"Yes"}};
	}
	@DataProvider(name="Explorer")
	public static Object[][] explorer(){
		return new Object[][]{new String[]{"Hide"},{"Show"},{"Collapsed"}};
	}
	@DataProvider(name="Toolbar")
	public static Object[][] toolbar(){
		return new Object[][]{new String[]{"Hide"},{"Show"}};
	}
}
