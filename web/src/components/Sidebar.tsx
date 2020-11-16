import React from "react";
import {
  Box,
  Flex,
  Heading,
  Icon,
  Image,
  Link,
  List,
  ListIcon,
  ListItem,
  Text,
  useColorMode,
} from "@chakra-ui/react";
import { FiWind } from "react-icons/fi";
import { Link as ReactRouterDom, useHistory } from "react-router-dom";

import logo from "../assets/favicon.png";
import menuConfig from "../config/menu";

interface SidebarProps {
  isOpen: boolean;
  onToggle: any;
}

const Sidebar = (props: SidebarProps) => {
  const history = useHistory();
  const { colorMode } = useColorMode();

  const color = { light: "brand.200", dark: "brand.100" };
  const bgColor = { light: "brand.300", dark: "brand.600" };
  const supportColor = { light: "brand.50", dark: "white" };

  return (
    <Box
      minH="100vh"
      width={props.isOpen ? "16.5rem" : "5rem"}
      position="fixed"
      bg={bgColor[colorMode]}
      color={color[colorMode]}
      transitionDuration=".5s"
      __css={{
        _hover: {
          width: "16.5rem",
          div: {
            visibility: "visible",
            li: { visibility: "visible", a: { visibility: "visible" } },
          },
        },
      }}
    >
      <Flex
        h="4.5rem"
        px={5}
        alignItems="center"
        visibility={props.isOpen ? "visible" : "hidden"}
      >
        <Image
          src={logo}
          h={8}
          w={8}
          bg="white"
          borderRadius="md"
          visibility="visible"
        />
        <Heading
          as="h1"
          ml={2}
          fontSize={20}
          fontWeight="400"
          color={supportColor[colorMode]}
          whiteSpace="nowrap"
          transitionDuration=".3s"
        >
          Grupo J. Sá
        </Heading>
        <Icon
          as={FiWind}
          fontSize={24}
          color={supportColor[colorMode]}
          cursor="pointer"
          transitionDuration={props.isOpen ? ".5s" : ".2s"}
          ml="auto"
          onClick={props.onToggle}
          _hover={{ color: "#1dc4e9" }}
        />
      </Flex>
      <Flex flexDirection="column" height="calc(100vh - 4.5rem)">
        <List overflow="hidden">
          {menuConfig.navitens.map((navitem, index) => (
            <React.Fragment key={index}>
              <ListItem
                textTransform="uppercase"
                fontSize="10px"
                fontWeight="600"
                color={supportColor[colorMode]}
                paddingX={5}
                pt={6}
                pb={1}
                visibility={props.isOpen ? "visible" : "hidden"}
              >
                <Text
                  as="span"
                  mb="0.5rem"
                  display="inline-block"
                  whiteSpace="nowrap"
                >
                  {navitem.caption}
                </Text>
              </ListItem>
              {navitem.navlinks.map((navlink, index) => (
                <ListItem
                  key={index}
                  d="block"
                  bg={
                    history.location.pathname === navitem.path + navlink.path
                      ? "brand.500"
                      : "transparent"
                  }
                  position="relative"
                  borderLeft="2px solid transparent"
                  transitionProperty="color"
                  transitionDuration=".5s"
                  _hover={{ color: "#1dc4e9", borderLeftColor: "#1dc4e9" }}
                >
                  <Link
                    as={ReactRouterDom}
                    to={navitem.path + navlink.path}
                    d="block"
                    mt="5px"
                    position="relative"
                    paddingY="7px"
                    pl={props.isOpen ? "13px" : "23px"}
                    pr="15px"
                    fontSize="14px"
                    whiteSpace="nowrap"
                    _hover={{ textDecoration: "none" }}
                    visibility={props.isOpen ? "visible" : "hidden"}
                  >
                    <Box
                      fontSize="1rem"
                      as="span"
                      paddingX="4px"
                      paddingY="7px"
                      mr="7px"
                      d="inline-flex"
                      alignItems="center"
                      h="30px"
                      w="30px"
                      fontWeight="600"
                    >
                      <ListIcon
                        as={navlink.icon}
                        mx="auto"
                        visibility="visible"
                      />
                    </Box>
                    <Box as="span" position="absolute" top="11px">
                      {navlink.title}
                    </Box>
                  </Link>
                </ListItem>
              ))}
            </React.Fragment>
          ))}
        </List>
      </Flex>
    </Box>
  );
};

export default Sidebar;
