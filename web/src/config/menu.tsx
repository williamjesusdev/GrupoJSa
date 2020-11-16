import { FiHome, FiList, FiMap } from "react-icons/fi";

const menuConfig = {
  navitens: [
    {
      caption: "navegação",
      path: "/",
      navlinks: [
        {
          title: "Dashboard",
          path: "",
          icon: FiHome,
        },
      ],
    },
    {
      caption: "empresa",
      path: "/empresas",
      navlinks: [
        {
          title: "Ver Empresas",
          path: "",
          icon: FiList,
        },
      ],
    },
    {
      caption: "imobiliária",
      path: "/imobiliaria",
      navlinks: [
        {
          title: "Ver Imóveis",
          path: "/imoveis",
          icon: FiMap,
        },
      ],
    },
  ],
};

export default menuConfig;
