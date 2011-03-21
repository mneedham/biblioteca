Feature: Biblioteca 
  Scenario: Initial loading	
    When I run "/System/Library/Frameworks/JavaVM.framework/Versions/1.6/Home/bin/java -classpath /Users/mneedham/Documents/ThoughtWorksUniversity/Biblioteca/out/production/Biblioteca main.Program" interactively
    And I type "9"
    Then the output should contain:	
    """
    Welcome to The Bangalore Public Library System - Biblioteca
    """
