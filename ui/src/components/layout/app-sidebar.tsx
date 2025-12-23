//import { useLayout } from '@/components/layout/layout-provider'
import {
  Sidebar,
  SidebarContent,
  SidebarFooter,
  SidebarHeader,
  SidebarRail,
} from '@/components/ui/sidebar';
import { sidebarData } from '@/constants/sidebar-data';
import { NavGroup } from './nav-group';
import { AppTitle } from './app-title';

export function AppSidebar() {
  //const { collapsible, variant } = useLayout()
  return (
    <Sidebar
      collapsible={'icon'}
      variant={'floating'}
    >
      <SidebarHeader>
        <AppTitle />
      </SidebarHeader>
      <SidebarContent>
        {sidebarData.navGroups.map((props) => (
          <NavGroup
            key={props.title}
            {...props}
          />
        ))}
      </SidebarContent>
      <SidebarFooter></SidebarFooter>
      <SidebarRail />
    </Sidebar>
  );
}
