public class MapRouter {
    public static Boolean getbreakconditions(String currentmap) {
        String breakcondition = getvalue(currentmap, "breakconditions");
        if (breakcondition.equals("true")) {
            return true;
        } else if (breakcondition == null) {
            System.out.println("no breakconditions found, going with false");
            return false;
        } else {
            return false;
        }
    }
    public static void updategrabables(String map, String[][] input) {
        grabablestoupdate = input;
        getvalue(map, "setgrabables");
    }
    public static String[][] grabablestoupdate;
    public static String[] movement_commands(String currentmap) {
        getvalue(currentmap, "movements");
        return refmovement_commands;
    }
    public static String[][] usables(String currentmap) {
        getvalue(currentmap, "movements");
        return refusables;
    }
    public static String[][] grabables(String currentmap) {
        getvalue(currentmap, "movements");
        return refgrabables;
    }
    public static String up(String currentmap) {
        getvalue(currentmap, "movements");
        return refup;
    }
    public static String down(String currentmap) {
        getvalue(currentmap, "movements");
        return refdown;
    }
    public static String north(String currentmap) {
        getvalue(currentmap, "movements");
        return refnorth;
    }
    public static String east(String currentmap) {
        getvalue(currentmap, "movements");
        return refeast;
    }
    public static String south(String currentmap) {
        getvalue(currentmap, "movements");
        return refsouth;
    }
    public static String west(String currentmap) {
        getvalue(currentmap, "movements");
        return refwest;
    }
    public static Integer animation_frames(String currentmap) {
        getvalue(currentmap, "animation");
        return refanimation_frames;
    }
    public static Integer map_height(String currentmap) {
        getvalue(currentmap, "animation");
        return refmap_height;
    }
    public static void showmap(String currentmap) {
        getvalue(currentmap, "showmap");
    }
    public static void use(String currentmap, String item) {
        itemtouse = item;
        getvalue(currentmap, "use");
    }
    public static String itemtouse;
    public static String[] refmovement_commands;
    public static String[][] refusables;
    public static String[][] refgrabables;
    public static String refup;
    public static String refdown;
    public static String refnorth;
    public static String refeast;
    public static String refsouth;
    public static String refwest;
    public static Integer refanimation_frames;
    public static Integer refmap_height;
    public static String getvalue(String currentmap, String type) {
        if (currentmap.equals("Ship_Down")) {
            Ship_Down ref = new Ship_Down();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("Ship_Up")) {
            Ship_Up ref = new Ship_Up();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("Hallway1")) {
            Hallway1 ref = new Hallway1();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("Room1")) {
            Room1 ref = new Room1();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("North_Rinlund_Town_Center")) {
            North_Rinlund_Town_Center ref = new North_Rinlund_Town_Center();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("Start_forest_1")) {
            Start_forest_1 ref = new Start_forest_1();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("Workhouse_upstairs_north")) {
            Workhouse_upstairs_north ref = new Workhouse_upstairs_north();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("Workhouse_upstairs_south")) {
            Workhouse_upstairs_south ref = new Workhouse_upstairs_south();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("Start_forest_2")) {
            Start_forest_2 ref = new Start_forest_2();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("Start_forest_3")) {
            Start_forest_3 ref = new Start_forest_3();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("Start_forest_4")) {
            Start_forest_4 ref = new Start_forest_4();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("Hallway1_2")) {
            Hallway1_2 ref = new Hallway1_2();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("Downstairs_workhouse")) {
            Downstairs_workhouse ref = new Downstairs_workhouse();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("NRTC_11")) {
            NRTC_11 ref = new NRTC_11();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("NRTC_12")) {
            NRTC_12 ref = new NRTC_12();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("NRTC_13")) {
            NRTC_13 ref = new NRTC_13();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("NRTC_14")) {
            NRTC_14 ref = new NRTC_14();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("NRTC_21")) {
            NRTC_21 ref = new NRTC_21();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("NRTC_22")) {
            NRTC_22 ref = new NRTC_22();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("NRTC_23")) {
            NRTC_23 ref = new NRTC_23();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("NRTC_24")) {
            NRTC_24 ref = new NRTC_24();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("NRTC_31")) {
            NRTC_31 ref = new NRTC_31();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("NRTC_32")) {
            NRTC_32 ref = new NRTC_32();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("NRTC_33")) {
            NRTC_33 ref = new NRTC_33();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("NRTC_34")) {
            NRTC_34 ref = new NRTC_34();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("NRTC_41")) {
            NRTC_41 ref = new NRTC_41();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("NRTC_42")) {
            NRTC_42 ref = new NRTC_42();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("NRTC_43")) {
            NRTC_43 ref = new NRTC_43();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        if (currentmap.equals("NRTC_44")) {
            NRTC_44 ref = new NRTC_44();
            if (type.equals("breakconditions")) {
                Boolean bc = ref.breakconditions();
                if (bc) {
                    return "true";
                } else {
                    return "false";
                }
            }
            if (type.equals("movements")) {
                refmovement_commands = ref.movement_commands;
                refusables = ref.usables;
                refgrabables = ref.grabables;
                refup = ref.up;
                refdown = ref.down;
                refnorth = ref.north;
                refeast = ref.east;
                refsouth = ref.south;
                refwest = ref.west;
                return "This should not be used as an output, I am here to update \"movements\"";
            }
            if (type.equals("animation")) {
                refanimation_frames = ref.animation_frames;
                refmap_height = ref.map_height;
                return "This should not be used as an output, I am here to update \"animation\"";
            }
            if (type.equals("showmap")) {
                ref.showmap();
                return "This should not be used as an output, I am here to update \"showmap\"";
            }
            if (type.equals("setgrabables")) {
                ref.grabables = grabablestoupdate;
                return "This should not be used as an output, I am here to update \"setgrabables\"";
            }
            if (type.equals("use")) {
                ref.use(itemtouse);
                return "This should not be used as an output, I am here to update \"use\"";                
            }
        }

        System.out.println("Map not found, returning null");
        return null;
    }
}
