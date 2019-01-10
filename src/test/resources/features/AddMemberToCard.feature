Feature: Add member to Card in Trello

  Background: Create list to board in Trello
    Given I Log in with user "{credentials.owner1}"
    When I create a board from "board drawer" with a:
      | Title | ATB |
    And I add new list into board
      | Name | To Do |
    And I create a card with a:
      | card1 |

  Scenario: Add Member to card
    Given I invite a member to the Board:
      | Member | "{credentials.member1}" |
    And I select the card:
      | List Name | To Do |
      | Card Name | card1 |
    When I assign a member to the card:
      | Member | "{credentials.member1}" |
    Then I see the member in the card
      | Member | "{credentials.member1}" |