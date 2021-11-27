#include <cctype>
#include <iostream>
#include <sstream>
#include <string>
#include <windows.h>

int const INITIAL_STICK_AMOUNT        = 20;
int const MINIMUM_DEFAULT_INPUT_VALUE = 1;
int const MAXIMUM_DEFAULT_INPUT_VALUE = 3;

inline void ClearScreen()
{
    // windows-specific-code
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

inline bool IsNumber(const std::string& s)
{
    std::string::const_iterator it = s.begin();
    while (it != s.end() && std::isdigit(*it))
    {
        ++it;
    }
    return !s.empty() && (it == s.end());
}

inline bool ReadIntegerInput(int& inputValue)
{
    std::string inputLine;
    std::getline(std::cin, inputLine);
    std::istringstream iss(inputLine);
    iss >> inputValue;
    return IsNumber(inputLine);
}

inline void DisplayGameStatus(int const& remainingSticks)
{
    ClearScreen();
    std::cout << "Es sind noch " << std::to_string(remainingSticks) << " auf dem Stapel.";
}

inline void ExecutePlayerMove(int& remainingSticks)
{
    int inputValue          = 0;
    int const maxInputValue = std::_Min_value(remainingSticks, MAXIMUM_DEFAULT_INPUT_VALUE);

    do
    {
        std::cout << std::endl
                  << "Bitte zwischen " << std::to_string(MINIMUM_DEFAULT_INPUT_VALUE) << " und " << std::to_string(maxInputValue) << " Streichh\x94lzer ziehen: ";
    } while (!ReadIntegerInput(inputValue) && !(inputValue >= MINIMUM_DEFAULT_INPUT_VALUE && inputValue <= maxInputValue));

    remainingSticks -= inputValue;
}

inline void ExecuteComputerMove(int& remainingSticks)
{
    int computerValue = 0;

    if (remainingSticks <= (MAXIMUM_DEFAULT_INPUT_VALUE + MINIMUM_DEFAULT_INPUT_VALUE))
    {
        computerValue = std::_Max_value(remainingSticks - MINIMUM_DEFAULT_INPUT_VALUE, MINIMUM_DEFAULT_INPUT_VALUE);
    }
    else
    {
        computerValue = std::_Min_value(MAXIMUM_DEFAULT_INPUT_VALUE, remainingSticks - 2 * MINIMUM_DEFAULT_INPUT_VALUE - MAXIMUM_DEFAULT_INPUT_VALUE);
    }

    std::cout << "Der Computer hat " << std::to_string(computerValue) << " Streichh\x94lzer gezogen." << std::endl;

    remainingSticks -= computerValue;
}

void main(int const argc, char** const argv)
{
    int remainingSticks = INITIAL_STICK_AMOUNT;

    do
    {
        DisplayGameStatus(remainingSticks);
        ExecutePlayerMove(remainingSticks);

        if (remainingSticks <= 0)
        {
            std::cout << "==== SPIELENDE ====" << std::endl;
            std::cout << "Sie haben verloren !" << std::endl;
            break;
        }

        ExecuteComputerMove(remainingSticks);

        if (remainingSticks <= 0)
        {
            std::cout << "==== SPIELENDE ====" << std::endl;
            std::cout << "Sie haben gewonnen !" << std::endl;
            break;
        }

        Sleep(2000);
    } while (remainingSticks > 0);
}