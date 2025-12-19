import { Sidebar, SidebarHeader, SidebarContent, SidebarFooter, 
    SidebarMenu,SidebarMenuItem, SidebarMenuButton,SidebarGroup,SidebarGroupContent } from "@/components/ui/sidebar";
import { Button } from "@/components/ui/button";
import { useSidebar } from "@/components/ui/sidebar";
import { LogOutIcon } from "lucide-react";
import { Logo } from "@/assets/Logo";

import { APP_SIDEBAR } from "@/constants";
import { useEffect } from "react";

export const AppSidebar = () => {
    const {isMobile, toggleSidebar} = useSidebar();
    
    useEffect(() => toggleSidebar(), [toggleSidebar]);
    
    return (
        <Sidebar variant="floating" collapsible="icon">
            {/** Sidebar Header */}
            <SidebarHeader>
                <SidebarMenu>
                    <SidebarMenuItem>
                        <Logo variant={isMobile ? 'default' : 'icon'} />
                    </SidebarMenuItem>
                </SidebarMenu>
                {/** Sidebar Content */}
                <SidebarContent>
                    <SidebarGroup>
                        <SidebarGroupContent>
                            <SidebarMenu>
                                {APP_SIDEBAR.primaryNav.map(item => (
                                    <SidebarMenuItem key={item.title}>
                                        <SidebarMenuButton tooltip={item.title} asChild>
                                            <a href={item.url}>
                                                <item.Icon />
                                                <span>{item.title}</span>
                                            </a>
                                        </SidebarMenuButton>
                                    </SidebarMenuItem>
                                ))}
                            </SidebarMenu>
                        </SidebarGroupContent>
                    </SidebarGroup>
                </SidebarContent>
            </SidebarHeader>
        </Sidebar>
    );
}