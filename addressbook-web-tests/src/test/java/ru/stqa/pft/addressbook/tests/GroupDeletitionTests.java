package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletitionTests extends TestBase{

    @Test
    public void testGroupDeletition(){
        app.gotoGroupPage();
        app.selectGroup();
        app.deleteSelectedGroups();
        app.returnToGroupPage();
    }

}
