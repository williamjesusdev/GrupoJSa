import React from "react";
import { useColorMode, Box, BoxProps } from "@chakra-ui/react";

const PageWrapper = (props: BoxProps) => {
  const { colorMode } = useColorMode();

  const bgColor = { light: "brand.50", dark: "brand.500" };

  const color = { light: "brand.600", dark: "brand.100" };
  return (
    <Box
      position="relative"
      height="100vh"
      width="100vw"
      bg={bgColor[colorMode]}
      color={color[colorMode]}
      {...props}
    />
  );
};

export default PageWrapper;
