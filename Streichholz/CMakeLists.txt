cmake_minimum_required(VERSION 3.6.2)

set(PROJECT_NAME Streichholz)

project(${PROJECT_NAME} LANGUAGES CXX VERSION 1.0)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED True)

set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/lib)
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/lib)
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/bin)

set(HEADER_FILE_PATH ${CMAKE_CURRENT_SOURCE_DIR}/include)
set(SOURCE_FILE_PATH ${CMAKE_CURRENT_SOURCE_DIR}/src)

file(GLOB_RECURSE HEADER_FILES "${HEADER_FILE_PATH}/*")

set(SOURCE_FILES
	src/main.cpp
)

add_executable(${PROJECT_NAME} ${SOURCE_FILES} ${HEADER_FILES})

target_include_directories(${PROJECT_NAME} PUBLIC "${CMAKE_CURRENT_SOURCE_DIR}/include/")