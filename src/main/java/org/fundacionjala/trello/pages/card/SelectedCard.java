package org.fundacionjala.trello.pages.card;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * this class represent a selected card page.
 */
public class SelectedCard extends AbstractPage {

    @FindBy(css = ".js-archive-card")
    private WebElement archiveCardButton;

    @FindBy(css = ".js-delete-card")
    private WebElement deleteCardButton;

    @FindBy(css = ".js-confirm.full.negate")
    private WebElement confirmDeleteCardButton;

    @FindBy(css = ".js-search-mem.js-autofocus")
    private WebElement searchMemberInputText;

    @FindBy(css = ".js-change-card-members")
    private WebElement membersButton;

    private By cardName = By.cssSelector(".js-card-name");


    /**
     * this method return value card.
     *
     * @return type String.
     */
    public String getValue() {
        return action.getValue(cardName);
    }

    /**
     * Method for archive the card.
     */
    public void archiveCard() {
        action.click(archiveCardButton);
    }

    /**
     * Method for delete card.
     */
    public void deleteCard() {
        action.click(deleteCardButton);
        action.click(confirmDeleteCardButton);
    }

    /**
     * Method for assing member to a card.
     *
     * @param memberName Input string of member name.
     */
    public void assignMemberToCard(final String memberName) {
        action.click(membersButton);
        action.setValue(searchMemberInputText, memberName);
        By member = By.xpath(String.format("//*[contains(text(),'%s')]/ancestor::a", memberName));
        action.click(driver.findElement(member));
    }
}