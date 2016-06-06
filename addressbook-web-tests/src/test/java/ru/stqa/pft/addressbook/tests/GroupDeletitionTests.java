package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletitionTests extends TestBase{

    @Test
    public void testGroupDeletition(){
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }

}
