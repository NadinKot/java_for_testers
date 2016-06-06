package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupDeletitionTests extends TestBase{

    @Test
    public void testGroupDeletition(){
        gotoGroupPage();
        selectGroup();
        deleteSelectedGroups();
        returnToGroupPage();
    }

}
