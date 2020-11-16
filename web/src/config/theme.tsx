import { extendTheme, Theme } from "@chakra-ui/react";

const theme: Theme = extendTheme({
  colors: {
    black: "#16161D",
    brand: {
      50: "#f4f7fc",
      100: "#e8edf7",
      200: "#a9b7d0",
      300: "#3f4d67",
      400: "#39465e",
      500: "#333f54",
      600: "#888888",
      700: "#495057",
    },
  },
  fonts: {
    body: `'Open Sans', sans-serif`,
    heading: `'Open Sans', sans-serif`,
  },
  breakpoints: {
    sm: "30em",
    md: "48em",
    lg: "62em",
    xl: "80em",
  },
  styles: {
    global: {
      svg: {
        _before: {
          BackgroundClip: "text",
          TextFillColor: "transparent",
          WebkitBackgroundClip: "text",
          WebkitTextFillColor: "transparent",
        },
      },
    },
  },
});

export default theme;
