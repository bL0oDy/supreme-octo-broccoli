#include <algorithm>
#include <cctype>
#include <iostream>
#include <sstream>
#include <string>
#include <windows.h>

// Avoid Magic Numbers
int const INITIAL_STICK_AMOUNT         = 20;   // Initial amount of sticks
int const MINIMUM_DEFAULT_INPUT_VALUE  = 1;    // Minimum amount of sticks to be taken at once
int const MAXIMUM_DEFAULT_INPUT_VALUE  = 3;    // Maximum amount of sticks to be taken at once
int const COMPUTER_CHOICE_DISPLAY_TIME = 2000; // Sleep Time after each round, enough time to read the computers move
int const EXECUTION_STATE_AMOUNT       = 2;    // Amount of different execution states

enum class ExecutionState : int
{
    PlayerMove   = 0,
    ComputerMove = 1
};

// Foreign Code Snippet
void ClearScreen()
{
    char fill = ' ';
    COORD tl  = { 0, 0 };
    CONSOLE_SCREEN_BUFFER_INFO s;
    HANDLE console = GetStdHandle(STD_OUTPUT_HANDLE);
    GetConsoleScreenBufferInfo(console, &s);
    DWORD written, cells = s.dwSize.X * s.dwSize.Y;
    FillConsoleOutputCharacter(console, fill, cells, tl, &written);
    FillConsoleOutputAttribute(console, s.wAttributes, cells, tl, &written);
    SetConsoleCursorPosition(console, tl);
}

// Foreign Code Snippet
bool IsNumber(std::string const& text)
{
    std::string::const_iterator it = text.begin();

    while (it != text.end() && std::isdigit(*it))
    {
        ++it;
    }

    return !text.empty() && (it == text.end());
}

inline bool TryReadIntegerInput(int& inputValue)
{
    inputValue = 0;
    try
    {
        std::string inputLine;
        std::getline(std::cin, inputLine);
        std::istringstream iss(inputLine);
        iss >> inputValue;

        return IsNumber(inputLine);
    }
    catch (std::exception const& exception)
    {
        std::cerr << exception.what() << std::endl;
    }

    return false;
}

inline void DisplayGameStatus(int const& remainingSticks)
{
    ClearScreen();
    std::cout << "Es liegen noch " << std::to_string(remainingSticks) << " auf dem Stapel." << std::endl;
}

inline void ExecutePlayerMove(int& remainingSticks)
{
    int inputValue          = 0;
    int const maxInputValue = std::min(remainingSticks, MAXIMUM_DEFAULT_INPUT_VALUE);

    do
    {
        std::cout << "Bitte zwischen "
                  << std::to_string(MINIMUM_DEFAULT_INPUT_VALUE)
                  << " und "
                  << std::to_string(maxInputValue)
                  << " Streichh\x94lzer ziehen: ";

    } while (!TryReadIntegerInput(inputValue) || !(inputValue >= MINIMUM_DEFAULT_INPUT_VALUE && inputValue <= maxInputValue));

    remainingSticks -= inputValue;
}

inline void ExecuteComputerMove(int& remainingSticks)
{
    int computerValue = 0;

    if (remainingSticks <= (MAXIMUM_DEFAULT_INPUT_VALUE + MINIMUM_DEFAULT_INPUT_VALUE))
    {
        computerValue = std::max(remainingSticks - MINIMUM_DEFAULT_INPUT_VALUE, MINIMUM_DEFAULT_INPUT_VALUE);
    }
    else
    {
        computerValue = std::min(MAXIMUM_DEFAULT_INPUT_VALUE, remainingSticks - 2 * MINIMUM_DEFAULT_INPUT_VALUE - MAXIMUM_DEFAULT_INPUT_VALUE);
    }

    std::cout << "Der Computer hat " << std::to_string(computerValue) << " Streichh\x94lzer gezogen." << std::endl;

    remainingSticks -= computerValue;

    Sleep(COMPUTER_CHOICE_DISPLAY_TIME);
}

void UpdateExecutionState(ExecutionState& currentState)
{
    currentState = (ExecutionState)(((int)currentState + 1) % EXECUTION_STATE_AMOUNT);
}

void ExecuteMove(ExecutionState const currentState, int& remainingSticks)
{
    switch (currentState)
    {
    case ExecutionState::PlayerMove:
        ExecutePlayerMove(remainingSticks);
        break;

    case ExecutionState::ComputerMove:
        ExecuteComputerMove(remainingSticks);
        break;
    }
}

void DisplayGameReport(ExecutionState const currentState)
{
    std::cout << "==== SPIELENDE ====" << std::endl;

    switch (currentState)
    {
    case ExecutionState::PlayerMove:
        std::cout << "Sie haben gewonnen!";
        break;
    case ExecutionState::ComputerMove:
        std::cout << "Sie haben verloren!";
        break;
    }
}

/*
	Mainprogram uses methods only, trying to improve readability
*/
int main(int const argc, char** const argv)
{
    ExecutionState currentState = ExecutionState::PlayerMove;
    int remainingSticks         = INITIAL_STICK_AMOUNT;

    do
    {
        DisplayGameStatus(remainingSticks);
        ExecuteMove(currentState, remainingSticks);
        UpdateExecutionState(currentState);

    } while (remainingSticks > 0);

    DisplayGameReport(currentState);
    return 0;
}