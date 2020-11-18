import React from "react";
import { useColorMode, FlexProps, Flex } from "@chakra-ui/react";

const Card = (props: FlexProps) => {
  const { colorMode } = useColorMode();

  const bgColor = { light: "white", dark: "brand.500" };

  return (
    <Flex
      border="none"
      position="relative"
      transition="all 0.5s"
      bg={bgColor[colorMode]}
      {...props}
    />
  );
};

export default Card;
